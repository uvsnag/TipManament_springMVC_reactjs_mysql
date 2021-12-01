import React from 'react';
import PropTypes from 'prop-types';
import './style/style.css';
import constant from "./common/constants";
import _ from 'lodash';

class CreateMaster extends React.Component {

    static get propTypes() {
        return {
            message: PropTypes.string, // just an example
        }
    }

    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            index: null,
            idParent: null,
            title: null,
            typeCategory: null,
            categoryInfo: {

            },
        };
    }
    componentDidMount() {
        this.setState({
            index: (new URLSearchParams(window.location.search)).get("id"),
            idParent: (new URLSearchParams(window.location.search)).get("id-parent"),
            typeCategory: (new URLSearchParams(window.location.search)).get("type"),

        }, () => {
            if (_.isNull(this.state.typeCategory)) {
                window.location.replace("http://" + window.location.host);
            }
            this.setState(
                {
                    title: (_.isNull(this.state.index) ? 'Create ' : 'Edit ') + this.state.typeCategory
                }
            )
            if (!_.isNull(this.state.index)) {
                this.getCategoryById();
            }
        });

    }
    getCategoryById() {
        var url = constant.BASE_URL + (this.state.typeCategory === 'sub' ? "view-sub?" : "view-master?");
        fetch(url + new URLSearchParams({
            id: this.state.index,
        }),
            {
                method: 'GET'
            }
        )
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        isLoaded: true,
                        categoryInfo: !_.isEmpty(result) ? result : {},
                    });
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )
    }
    onSave() {

        fetch(constant.BASE_URL + 'save', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            // refer to https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON/stringify
            // to get more infor about create json with stringify

            body: JSON.stringify({
                id: this.state.index,
                name: this.state.categoryInfo.name,
                description: this.state.categoryInfo.description,
                idParent: this.state.idParent,
                typeCategory: this.state.typeCategory,
                typeUpdate: _.isNull(this.state.index) ? 'insert' : 'update',
            })
        })
            .then(
                // history.push('/new-location')
                // this.props.history.push("/")
            )

    }

    handleChange(event, typeName) {
        switch (typeName) {
            // case 'id':
            //     this.setState(prevState => ({
            //       categoryInfo: {                   // object that we want to update
            //         ...prevState.categoryInfo,    // keep all other key-value pairs
            //         id: event.target.value       // update the value of specific key
            //       }
            //     }))
            //     break;
            case 'name':
                this.setState(prevState => ({
                    categoryInfo: {
                        ...prevState.categoryInfo,
                        name: event.target.value
                    }
                }))
                break;
            case 'description':
                this.setState(prevState => ({
                    categoryInfo: {
                        ...prevState.categoryInfo,
                        description: event.target.value
                    }
                }))
                break;

            default:
                break;
        }
    }

    render() {
        return (

            <div>
                <div id='title-edit-type'>{this.state.title}</div>
                <div className="frame">
                    <form >
                        {/* <input type="hidden" name="type-update" value="update" /> */}

                        <div>
                            <div>
                                <input type="hidden" name="index" value={this.state.categoryInfo.id}
                                    onChange={(e) => {
                                        this.handleChange(e, "id")
                                    }} />
                            </div>
                        </div>
                        <div>

                            <div>Name:</div>
                            <div>
                                <textarea className='input-name' value={this.state.categoryInfo.name}
                                    onChange={(e) => {
                                        this.handleChange(e, "name")
                                    }} ></textarea>
                            </div>
                        </div>
                        <div>

                            <div>Description:</div>
                            <div>
                                <textarea className='input-name' value={this.state.categoryInfo.description}
                                    onChange={(e) => {
                                        this.handleChange(e, "description")
                                    }} ></textarea>
                            </div>
                        </div>
                        <div>
                            <br />
                            <div>
                                <input type="submit" value="Save" onClick={() => this.onSave()} />
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        );
    }
}

export default CreateMaster;