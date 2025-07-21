import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import './App.css';
import Game from './App'; // <-- Change 'App' to 'Game'

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Game /> {/* <-- Change <App /> to <Game /> */}
  </React.StrictMode>
);
