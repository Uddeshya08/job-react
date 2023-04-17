import * as React from 'react';
import Box, {BoxProps} from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Avatar from '@mui/material/Avatar';
import Stack from '@mui/material/Stack';
import Typography from '@mui/material/Typography';


function Item(props) {
  const { sx, ...other } = props;
  return (
    <Box
      sx={{
        bgcolor: (theme) => (theme.palette.mode === 'dark' ? '#101010' : '#fff'),
        color: (theme) => (theme.palette.mode === 'dark' ? 'grey.300' : 'grey.800'),
        border: '1px solid',
        borderColor: (theme) =>
          theme.palette.mode === 'dark' ? 'grey.800' : 'grey.300',
        p: 1,
        borderRadius: 2,
        fontSize: '0.875rem',
        fontWeight: '700',
        ...sx,
      }}
      {...other}
    />
  );
}

const profile = (
  <React.Fragment>
    <CardContent>
    <h2 style={{textAlign:'center'}}>Profile</h2>
    <Stack direction="row">
      <Avatar alt='U' src="/images/profile.png" />
    </Stack>
    <h3 style={{textAlign:'center'}}>Uddeshya Sharma</h3>
    </CardContent>
    <CardActions>
      <Button size="small">Learn More</Button>
    </CardActions>
  </React.Fragment>
);

export default function ProfileCard() {
  return (
    <Box
  sx={{
    display: 'grid',
    gridAutoColumns: '1fr',
    gap: 1,
  }}
>
<Item sx={{ gridRow: '1', gridColumn: '3/5' }}>{profile}</Item>
    </Box>
  );
}