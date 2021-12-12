import React, {useState, useEffect, useCallback} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

import ListClubComponent from './Components/ListClubComponent'
import HeaderComponent from './Components/HeaderComponent';
import FooterComponent from './Components/FooterComponent';



function App() {
  return (
    <div className="App">
      <HeaderComponent/>
      <div>
        <a href="Club.js">Admin Club Page</a>
        <div>
          <ListClubComponent/>
        </div>
      </div>
      <FooterComponent/>
    </div>
    
  );
}

export default App;
