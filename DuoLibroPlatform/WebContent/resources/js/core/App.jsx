import axios from 'axios'
import React, { Component } from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {

 constructor(props) {
    super(props);

        this.state = {
      		article: "Test"
    	}
    	this.getArticle = this.getArticle.bind(this);
    	
    	
  	}

   render() {
    
      return (
         <div>
            {this.getArticle()}
            
         </div>
         
      );
   }
   
     componentDidMount() {
 		var _this = this;
     	 axios.get('/DuoLibroPlatform/getArticle')
	    .then(function(response){

      	     _this.setState(
    		 { article: response.data.article }
   			);
	    });
   
  	}
  	
  	getArticle(){
  		return (<div>{this.state.article}</div>);
  	}
   

}
export default App;