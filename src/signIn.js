import * as React from 'react';
import { useState } from "react";
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { useNavigate } from "react-router-dom";
import {setJwtLocal, getJwtLocal, setUserId, getUserId} from "./localstorage/UserLocalStorage"


function Copyright(props) {
  return (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
      <Link color="inherit" href="https://mui.com/">
        Your Website
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

const theme = createTheme();

const SignIn = (props) => {
  const[username, setUsername] = useState('');
  const[password, setPassword] = useState('');
  const navigate = useNavigate();

 //const[jwt, setJwtLocal] = useLocalStorage("", "jwt");


  const loginUser = (e) => {
    const requestBody = {
        username: username,
        password: password
    }
    e.preventDefault();
    if(!username || !password){
        alert("Please enter credentials");
        return;
    }

    fetch("http://localhost:8082/authenticate", {
        headers: {
            "Content-Type": "application/json"
        },
        method: "post",
        body: JSON.stringify(requestBody)
    }).then((response) => (response.json()))
    .then((jsonResponse) => {
        // setJwtLocal(jsonResponse.jwt);
        setJwtLocal(jsonResponse.jwt, () => {
            console.log("Jwt token is saved" + jsonResponse.jwt);
        })
        setUserId(jsonResponse.userId, () => {
          console.log("UserId is saved" + jsonResponse.userId);
      })

    })
    .then(
        navigate("/dashboard")
    )
}




  // const loginUser = (e) => {
  //     const requestBody = {
  //         username: username,
  //         password: password
  //     }
  //     e.preventDefault();
  //     if(!username || !password){
  //         alert("Please enter credentials");
  //         return;
  //     }

  //     fetch("http://localhost:8082/authenticate", {
  //         headers: {
  //             "Content-Type": "application/json"
  //         },
  //         method: "post",
  //         body: JSON.stringify(requestBody)
  //     }).then((response) => (response.json()))
  //     .then((jsonResponse) => {
  //       console.log(jsonResponse)
  //         setJwtLocal(jsonResponse.jwt);
  //         localStorage.setItem("customer",jsonResponse.id)
          
  //     })
  //     .then(
  //         navigate("/dashboard")
  //     )
  //     console.log(requestBody)
  // }
  
      
    

  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Sign in
          </Typography>
          <Box component="form" onSubmit={loginUser} noValidate sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="username"
              value={username}
              onChange={(e) => setUsername(e.currentTarget.value)}
              label="User Name"
              name="Username"
              autoComplete="email"
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              value={password}
              onChange={(e) => setPassword(e.currentTarget.value)}
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
            />
            <FormControlLabel
              control={<Checkbox value="remember" color="primary" />}
              label="Remember me"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Sign In
            </Button>
            <Grid container>
              <Grid item xs>
                <Link href="#" variant="body2">
                  Forgot password?
                </Link>
              </Grid>
              <Grid item>
                <Link href="/signup" variant="body2">
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
        <Copyright sx={{ mt: 8, mb: 4 }} />
      </Container>
    </ThemeProvider>
  );
}
export default SignIn;