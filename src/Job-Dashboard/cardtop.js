import * as React from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { FormControl,InputLabel, Select, MenuItem } from '@mui/material';
import shadows from '@mui/material/styles/shadows';
import ProfileCard from './Profile';

const bull = (
  <Box
    component="span"
    sx={{ display: 'inline-block', mx: '2px', transform: 'scale(0.8)'}}
  >
    •
  </Box>
);

const card = (
  <React.Fragment>
    <CardContent>
    <FormControl sx={{ m: 1, minWidth: 120 }}>
  <InputLabel id="demo-simple-select-label">Skill</InputLabel>
  <Select
    labelId="demo-simple-select-label"
    id="demo-simple-select"
    value={10}
    label="Primary Skill"
   // onChange={handleChange}
  >
    <MenuItem value={10}>Java</MenuItem>
    <MenuItem value={20}>React</MenuItem>
    <MenuItem value={30}>Angular</MenuItem>

  </Select>
  </FormControl>
  <FormControl sx={{ marginLeft: 1, minWidth: 120 }}>
  <InputLabel id="demo-simple-select-label">Location</InputLabel>
  <Select
    labelId="demo-simple-select-label"
    id="demo-simple-select"
    value={10}
    label="Location"
   // onChange={handleChange}
  >
    <MenuItem value={10}>Pune</MenuItem>
    <MenuItem value={20}>Bhopal</MenuItem>
    <MenuItem value={30}>Banglore</MenuItem>
    
  </Select>
</FormControl>
<ProfileCard/>
    </CardContent>
    <CardActions>
      <Button size="small">Learn More</Button>
    </CardActions>
    
  </React.Fragment>
);

export default function OutlinedCard() {
  return (
    <Box sx={{ minWidth: 275, boxShadow: '0 0px 16px 0 #BDC9D7' }}>
      <Card variant="outlined">{card} </Card>
    </Box>
  );
}