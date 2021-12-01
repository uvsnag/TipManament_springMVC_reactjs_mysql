import React from 'react';

class Menu extends React.Component {

    myFunction() {
        var x = document.getElementById("myTopnav");
        if (x.className === "topnav") {
            x.className += " responsive";
        } else {
            x.className = "topnav";
        }
    }

    render() {
        return (

            <div className="topnav" id="myTopnav">
                <a href="http://localhost:8080/DemoJspVertica/simple">Simple-query</a>
                <a href="http://localhost:8080/DemoJspVertica/multi">Multi-query/Projection</a>
                <a href="http://localhost:8080/DemoJspVertica/analytic">SQL Analytics</a>
                <a href="http://localhost:8080/DemoJspVertica/function">Function</a>
                <a  href="/#" className="icon" onClick= {() => this.myFunction()}
                > <i
                        className="fa fa-bars"></i> </a>
            </div>
        );
    }
}

export default Menu;