import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

    state = {};

    generateJoke = () => {
        fetch('/api/getjokes')
            .then(response => response.text())
            .then(message => {
                this.setState({message: message});
            });
    };

    render() {
        return (
            <div className="App">
            <header className="App-header">
            <img src={logo} className="App-logo" alt="logo"/>
            <button onClick={this.generateJoke}> Refresh</button>
            <h3 className="App-title">{this.state.message}</h3>
            </header>
            <p className="App-intro">
            To get started, edit <code>src/App.js</code> and save to reload.
        </p>
        </div>
    );
    }
}

export default App;