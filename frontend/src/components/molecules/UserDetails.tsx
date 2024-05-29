import React from "react";
import { Box, Button, Grid, Typography } from "@mui/material";
import Image from "next/image";


export function UserDetails() {

  return (
    <Box padding='0.8rem'>
      <Grid container>
        <Grid item padding='0 1rem 4rem 1rem'>
          <Image
            src='/images/userIcon.svg'
            width={70}
            height={70}
            alt='user-icon'
          />
        </Grid>

        <Grid item>
          <Box>
            <Typography fontWeight='bold' fontSize='1.8rem'>John Doe</Typography>
            <Typography fontSize='1.4rem'>JohnDoe0005@gmail.com</Typography>
          </Box>
        </Grid>
      </Grid>
    </Box>
  );
}