import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  state = {
    selectedFile: null,
    message:null
  };
    generateJoke = () => {
        fetch('/api/getjokes')
            .then(response => response.text())
            .then(message => {
                this.setState({message: message});
            });
    };

    onFileChange = event => {
      this.setState({ selectedFile: event.target.files[0] });
      
    };

    onFileUpload = () => {
      const formData = new FormData();
      formData.append('csvFile',this.state.selectedFile);
      console.log(this.state.selectedFile);
      fetch(
        '/api/upload',
        {
          mode: 'no-cors',
          method: 'POST',
          body: formData,
        }
      )
        .then((response) => response.json())
        .then((result) => {
          console.log('Success:', result);
        })
        .catch((error) => {
          console.error('Error:', error);
        });
    };

    fileData = () => {
      if (this.state.selectedFile) {
          
        return (
          <div>
            <h2>File Details:</h2>
            <p>File Name: {this.state.selectedFile.name}</p>
  
            <p>File Type: {this.state.selectedFile.type}</p>
  
            <p>
              Last Modified:{" "}
              {this.state.selectedFile.lastModifiedDate.toDateString()}
            </p>
  
          </div>
        );
      } else {
        return (
          <div>
            <br />
            <h4>Choose before Pressing the Upload button</h4>
          </div>
        );
      }
    };
    render() {
        return (
            <div className="App">
            <header className="App-header">
            <img src={logo} className="App-logo" alt="logo"/>
            <button onClick={this.generateJoke}> Get Joke</button>
            <h3 className="App-title">{this.state.message}</h3>
            <div>
                            <input type="file" onChange={this.onFileChange} />
                            <button onClick={this.onFileUpload}>
                              Upload!
                            </button>
            </div>
            {this.fileData()}
            </header>
        </div>
    );
    }
}

export default App;