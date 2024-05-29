import { Box, Typography } from "@mui/material";
import Link from "next/link";
import React from "react";

interface LinkProps {
  link: string;
  linkText: string;
}

export function UserOption({ link, linkText }: LinkProps){


  return(
    <Box display='flex' borderTop='1px solid black' padding='1rem' paddingLeft='2rem'>
      <div>
        <Link href={link}>
          <Typography fontSize='1.4rem'>
            {linkText}
          </Typography>
        </Link>
      </div>
    </Box>
  );
}