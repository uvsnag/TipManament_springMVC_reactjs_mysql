import React from 'react';
import PropTypes from 'prop-types';
import _ from 'lodash';
import './style/style.css';
// import { Link } from "react-router-dom";
import constant from "./common/constants";
import { Spinner } from 'react-bootstrap';
import { Circle } from 'react-bootstrap-icons';
class SearchResult extends React.Component {

    static get propTypes() {
        return {
            message: PropTypes.string, // just an example
        }
    }

    constructor(props) {
        super(props);
        this.state = {
            error: null,
            searchStr: "",
            isLoaded: false,
            open: false,
            tips: [],
            typeUpdate: null,
            index: null,
        };
    }
    componentDidMount() {

        console.log("componentDidMount");
        this.setState({
            searchStr: (new URLSearchParams(window.location.search)).get("searchStr"),

        }, () => {
            this.search()
        });
    }
    componentWillMount() {
        console.log("componentWillMount");
        // this.setOpen(null);
    }
    onDelete(id, type) {
        fetch(constant.BASE_URL + "delete-temp?"
            + new URLSearchParams({
                type: type,
                id: id
            }),
            {
                method: 'PUT',
                // params: { 
                //   typeUpdate: this.state.typeUpdate,
                //   id: this.state.empInfo.index }
                // }
            }
        )
        window.location.replace("http://" + window.location.host);
    }
    search() {
        fetch(constant.BASE_URL + "find-tip?"
            + new URLSearchParams({
                strSearch: this.state.searchStr,
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
                        tips: !_.isEmpty(result) ? result : [],
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
        const { error, isLoaded, tips } = this.state;
        if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return (
                <div>
                    <Spinner animation="border" variant="primary" />
                </div>
                // <div>Loading...</div>
            );
        } else {
            var urlBase = "http://" + window.location.host;
            const listTips = !_.isEmpty(tips) ? tips.map(tip => {
                var classDeleted = _.isNull(tip.deleteDate) ? "not-detete" : "deteted"
                return (
                    <div>
                        <div className={`tip-detail-name`} >
                            {/* <Link className={`link-icon ${classDeleted}`} to={`${urlBase}/view-tip?id=${tip.id}`}>{tip.name}</Link> */}
                            <Circle className='icon-inlink' /> <a href={`${urlBase}/view-tip?id=${tip.id}`} className={`link-icon ${classDeleted}`}
                            >{tip.name}</a><br /><br />
                            {/* <button className='buton-transparent' onClick={() => this.onDelete(tip.id, 'tip')}>delete</button> */}
                        </div>
                    </div>
                )
            }
            ) : null;
            return (

                <div>
                    <div className="frame">
                        {listTips}
                    </div>
                    <br />

                </div>
            );
        }
    }
}
export default SearchResult;