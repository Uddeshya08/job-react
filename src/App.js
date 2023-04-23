import logo from './logo.svg';
import './App.css';
import {Navigate,BrowserRouter, Route, Routes} from 'react-router-dom';
import SignIn from './signIn';
import SignUp from './signUp';
import Dashboard from './Job-Dashboard/Dashboard';

function App() {
 return <BrowserRouter>
      <Routes>
      <Route path="/" element={<Navigate replace to="/signin" />} />
      <Route path = "signin" element={<SignIn />}></Route>
        <Route path = "signup" element={<SignUp />}></Route>
        <Route path = "dashboard" element={<Dashboard />}></Route>
        
      </Routes>
    </BrowserRouter>;
  
}


export default App;
