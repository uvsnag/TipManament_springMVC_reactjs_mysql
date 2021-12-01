import React from 'react';
import ReactDOM from 'react-dom';
/* import './index.css';
import App from './App'; */
import HomePage from "./homePage";
import ViewTip from "./viewTip";
import SearchResult from "./searchResult";
import CreateMaster from "./createMaster";
import reportWebVitals from './reportWebVitals';
import {Link, Route,  Routes, BrowserRouter } from "react-router-dom";
import CreateTip from './createTip';

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
    <div><Link to="/">Home</Link></div>
    <br/>
    <Routes>
        <Route exact path="/" element={<HomePage/>} />
         <Route path="/view-tip" element={<ViewTip/>} />
         <Route path="/create-category" element={<CreateMaster/>} />
         <Route path="/create-tip" element={<CreateTip/>} />
         <Route path="/search" element={<SearchResult/>} />
          
      </Routes>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
