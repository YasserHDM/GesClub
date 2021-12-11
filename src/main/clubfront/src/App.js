import React, {useState, useEffect, useCallback} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import {useDropzone} from 'react-dropzone'


const ClubProfiles = () => {
  const [ClubProfiles, setClubProfiles] = useState([]);

  const fetchClubProfiles = () => {
    axios.get("http://localhost:8080/api/club").then(res => {
      console.log(res);
      setClubProfiles(res.data);
    });
  }

  useEffect( () => {
    fetchClubProfiles();
  }, []);

  return ClubProfiles.map((clubProfiles, index) => {

    return (
      <div key={index}>
        <h1>{clubProfiles.nomClub}</h1>
        <ul>
          <li>id : {clubProfiles.idClub}</li>
          <li>descrption : {clubProfiles.descClub}</li>
          <li>date de creation : {clubProfiles.dateCre}</li>
          <li><Dropzone {...clubProfiles} /></li>
        </ul>
        <br></br>
        <br></br>
        <br></br>
      </div>
    )
  })
};

function Dropzone({ clubProfileId }) {
  const onDrop = useCallback(acceptedFiles => {
    const file = acceptedFiles[0];
    console.log(file);

    const formData = new FormData();
    formData.append("file", file);
    
    axios.post(
      'http://localhost:8080/api/${clubProfileId}/image/upload', 
      formData,
      {
        headers: {
          "Content-Type" : "multipart/form-data"
        }
      }
    )
    .then(() => {
      console.log("file  uploaded successfully");
    })
    .catch(err => {
      console.log(err);
    });
    
  }, [])
  const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the files here ...</p> :
          <p>Drag 'n' drop some files here, or click to select files</p>
      }
    </div>
  )
}

function App() {
  return (
    <div className="App">
     <ClubProfiles />
    </div>
  );
}

export default App;
