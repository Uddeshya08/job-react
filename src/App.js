import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import SignIn from './signIn';
import SignUp from './signUp';

function App() {
 return <BrowserRouter>
      <Routes>
        <Route path = "signin" element={<SignIn />}></Route>
        <Route path = "signup" element={<SignUp />}></Route>
      </Routes>
    </BrowserRouter>;
  
}


export default App;
