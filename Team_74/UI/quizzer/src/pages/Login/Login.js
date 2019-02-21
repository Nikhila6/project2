import React, { Component } from 'react';
import './Login.css';
import { Redirect } from 'react-router-dom';

// const Welcome = ({user, onSignOut})=> {
//   // This is a dumb "stateless" component
//   return (
//     <div>
//       Welcome <strong>{user.username}</strong>!
//       <a href="javascript:;" onClick={onSignOut}>Sign out</a>
//     </div>
//   )
// }

class LoginForm extends React.Component {
  
  // Using a class based component here because we're accessing DOM refs
 
  handleSignIn(e) {
    e.preventDefault()
    let username = this.refs.username.value;
    let password = this.refs.password.value;
    this.props.onSignIn(username, password);

  }
  
  render() {
    return (
      <form className="LoginForm" onSubmit={this.handleSignIn.bind(this)}>
        <div className="Login-formheader">
        <h3>Sign in</h3>
        </div>
        <input type="text" ref="username" required={true} placeholder="Enter your username" />
        <input type="password" ref="password" required={true} placeholder="Enter password" />
        <input type="submit" value="Login" />
      </form>
    )
  }

}


class Login extends React.Component {
  
  constructor(props) {
    super(props)
    localStorage.clear();
    // the initial application state
    this.state = {
      user: null
    }
  }
  
  // App "actions" (functions that modify state)
  signIn(username, password) {
    // This is where you would call Firebase, an API etc...
    // calling setState will re-render the entire app (efficiently!)

    this.setState({
      user: {
        username,
        password,
      }
    })

    localStorage.setItem('username',username);
    localStorage.setItem('password',password);
  }
  
  // signOut() {
  //   // clear out user from state
  //   this.setState({user: null})
  // }
  
  render() {
    // Here we pass relevant state to our child components
    // as props. Note that functions are passed using `bind` to
    // make sure we keep our scope to App
    return (
      <div>
        { 
          (this.state.user) ?
              <Redirect to='/home' />
          :
            <LoginForm 
             onSignIn={this.signIn.bind(this)} 
            />
        }
      </div>
    )
    
  }
  
}

export default Login;