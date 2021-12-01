import React from 'react';
import PropTypes from 'prop-types';
import _ from 'lodash';
import './style/style.css';
import constant from "./common/constants";
import Button from '@restart/ui/esm/Button';
import { PencilSquare } from 'react-bootstrap-icons';
import { Link } from "react-router-dom";

class ViewTip extends React.Component {

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
            tipDetail: {},
            typeUpdate: null,
            index: null,
        };
    }
    componentDidMount() {
        let id = (new URLSearchParams(window.location.search)).get("id");
        this.onGetTip(id);
    }
    onGetTip(index) {
        fetch(constant.BASE_URL + "view-tip?"  
        + new URLSearchParams({
            id: index
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
                    tipDetail: !_.isEmpty(result) ? result : {},
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
    render() {
        const { error, isLoaded, tipDetail } = this.state;
        var urlBase ="http://"+window.location.host;
        if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Loading...</div>;
        } else {
            const tipDisplay = !_.isEmpty(tipDetail) ? (
                    <div>
                        <div className="tip-name"> {tipDetail.name} </div>
                        <div className="tip-updateDate"> {tipDetail.updateDate} </div>
                        <br/>
                     <br/>
                        <div className="tip-contents" dangerouslySetInnerHTML={{ __html: tipDetail.contents }}></div>
                    </div>
            ): null;
            return (

                <div>

                    <div className="frame">
                    <Button ><a href={`${urlBase}/create-tip?id=${tipDetail.id}&id-parent=${tipDetail.idType}`}>
                    Edit<PencilSquare className='icon-inlink'/></a></Button>
                    <br/>
                    <br/>
                        {tipDisplay}
                    </div>
                </div>
            );
        }
    }
}

export default ViewTip;