import React, { useEffect, useState } from "react";
import './style/style.css';
import constant from "./common/constants";
import _ from 'lodash';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import DecoupledEditor from '@ckeditor/ckeditor5-build-decoupled-document';
const CreateTip = () => {
    const [index, setIndex] = useState(null);
    const [idParentChange, setIdParentChange] = useState(null);
    const [tipDetail, setTipDetail] = useState({
        name: null, id: null,
        contents: null, idType: null
    });
    const [state, setState] = useState({
        isGetTipLoaded: false,
    });
    const [subList, setSubList] = useState([]);
    const [isCreate, setIsCreate] = useState(true);


    useEffect(() => {
        var idTmp = new URLSearchParams(window.location.search).get("id");
        var idParentTmp = new URLSearchParams(window.location.search).get("id-parent")
        setIndex(idTmp);
        setTipDetail(tipDetail => ({ ...tipDetail, idType: idParentTmp, }));
        if (_.isNull(idParentTmp)) {
            window.location.replace("http://" + window.location.host);
        }
        if (!_.isNull(idTmp)) {
            setIsCreate(false);
            onGetTip(idTmp);
            getAllSub();
        }
    },[]);
    // useEffect(() => {
    //     var idTmp = new URLSearchParams(window.location.search).get("id");
    //     var idParentTmp = new URLSearchParams(window.location.search).get("id-parent")
    //     setIndex(idTmp);
    //     setTipDetail(tipDetail => ({ ...tipDetail, idType: idParentTmp, }));
    //     if (_.isNull(idParentTmp)) {
    //         window.location.replace("http://" + window.location.host);
    //     }
    //     if (!_.isNull(idTmp)) {
    //         setIsCreate(false);
    //         onGetTip(idTmp);
    //         getAllSub();
    //     }
    // },[index]);
    
    const onGetTip = (id) => {
        fetch(constant.BASE_URL + "view-tip?"
            + new URLSearchParams({
                id: id,
            }),
            {
                method: 'GET'
            }
        )
            .then(res => res.json())
            .then(
                (result) => {
                    // setTipDetail(!_.isEmpty(result) ? result : {})
                    if (!_.isEmpty(result)) {

                        setTipDetail({
                            ...tipDetail, id: result.id,
                            name: result.name,
                            contents: result.contents,
                            idType: result.idType,
                        })

                    }
                    setState({ ...state, isGetTipLoaded: true, })
                },
            )
    }
    const getAllSub = () => {
        fetch(constant.BASE_URL + "get-sub"
            ,
            {
                method: 'GET'
            }
        )
            .then(res => res.json())
            .then(
                (result) => {
                    // setTipDetail(!_.isEmpty(result) ? result : {})
                    if (!_.isEmpty(result)) {

                        setSubList(result)

                    }
                },
            )
    }

    const onSave = () => {
        var idType = (_.isNull(idParentChange) || idParentChange.length === 0) ? tipDetail.idType : idParentChange
        fetch(constant.BASE_URL + 'save-tip', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            // refer to https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON/stringify
            // to get more infor about create json with stringify

            body: JSON.stringify({
                id: index,
                name: tipDetail.name,
                contents: tipDetail.contents,
                idType: idType,
                typeUpdate: _.isNull(index) ? 'insert' : 'update',
            })
        })
            .then(
                // history.push('/new-location')
                // this.props.history.push("/")
            )
    }

    const handleChange = (value, typeName) => {
        if (state.isGetTipLoaded || _.isNull(index)) {

            switch (typeName) {
                case 'name':
                    setTipDetail(tipDetail => ({ ...tipDetail, name: value, }));
                    break;
                case 'contents':
                    setTipDetail(tipDetail => ({ ...tipDetail, contents: value, }));
                    break;
                case 'idType':
                    setIdParentChange(value);
                    break;
                default:
                    break;
            }
        }
    }
    
    const subLists = !_.isEmpty(subList) ? subList.map((sub) => {
        return (
            <option value={`${sub.id}`}>{sub.name}</option>
        )
    }) : null;
    return (
        <div>

            <div className="frame">
                <form >
                    {/* <input type="hidden" name="type-update" value="update" /> */}

                    <div>
                        <div>
                            <input type="hidden" name="index" value={tipDetail.id}
                                onChange={(e) => {
                                    handleChange(e.target.value, "id")
                                }} />
                        </div>
                    </div>
                    <div>

                        <div>Name:</div>
                        <div>
                            <textarea className='input-name' value={tipDetail.name}
                                onChange={(e) => {
                                    handleChange(e.target.value, "name")
                                }} ></textarea>
                        </div>
                    </div>
                    <div>

                        <div>class:</div>
                        <div>
                            <select onChange={(e) => {
                                handleChange(e.target.value, "idType")
                            }} >
                                <option value=''></option>
                                {subLists}
                            </select>
                            {/* <input type ='text'  value={tipDetail.idType}
                                onChange={(e) => {
                                    // handleChange(e.target.value, "idType")
                                }} ></input> */}
                        </div>
                    </div>
                    <div>

                        <div>contents:</div>
                        <div>
                            <CKEditor
                                onReady={editor => {
                                    console.log('Editor is ready to use!', editor);

                                    // Insert the toolbar before the editable area.
                                    editor.ui.getEditableElement().parentElement.insertBefore(
                                        editor.ui.view.toolbar.element,
                                        editor.ui.getEditableElement()
                                    );

                                    // this.editor = editor;
                                }}
                                onError={({ willEditorRestart }) => {
                                    // If the editor is restarted, the toolbar element will be created once again.
                                    // The `onReady` callback will be called again and the new toolbar will be added.
                                    // This is why you need to remove the older toolbar.
                                    if (willEditorRestart) {
                                        this.editor.ui.view.toolbar.element.remove();
                                    }
                                }}
                                onChange={(event, editor) => {
                                    const data = editor.getData();
                                    handleChange(data, "contents")

                                }
                                }
                                editor={DecoupledEditor}
                                data={tipDetail.contents}
                            // config={ /* the editor configuration */ }
                            />
                        </div>
                    </div>
                    <div>
                        <br />
                        <div>
                            <input type="submit" value="Save" onClick={() => onSave()} />
                        </div>
                    </div>
                </form>
            </div>
            {/* <button onClick ={()=> this.test()}>fx</button> */}
            {/* <Editor /> */}
            {/* <textarea id="editor"></textarea> */}
        </div>
    );

    // }
}

export default CreateTip;