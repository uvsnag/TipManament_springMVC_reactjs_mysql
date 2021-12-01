import React from "react";
import { BrowserRouter, Route, Link, Routes } from "react-router-dom";

// import './App.css';
import HomePage from "./HomePage";
import ViewTip from "./VIewTip";

class App extends React.Component {

  render()  {
    return  (
      <BrowserRouter>
        <div>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/view-tip">HomePage</Link>
            </li>
            <li>
              <Link to="/topics">Topics</Link>
            </li>
          </ul>

          <hr />
          <div className="main-route-place">
              <Routes>
            <Route exact path="/" element={<HomePage/>} />
            <Route path="/view-tip" element={<ViewTip/>} />
            {/* <Route path="/topics" component={Topics} /> */}
            </Routes>
          </div>
        </div>
      </BrowserRouter>
    );
  }

}
export default App;