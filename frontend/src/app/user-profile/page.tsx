import React from "react";
import { UserDetails } from "@/components/molecules/UserDetails";
import { UserOption } from "@/components/molecules/UserOption";
import { Box } from "@mui/material";

export default function UserProfile(){
  const userOptions = [
    {id: 0, link: "/profile-tickets", linkText: "My Tickets"},
    {id: 1, link: "/payment-historial", linkText: "Payment history"},
    {id: 2, link: "/edit-profile", linkText: "Edit Profile"},
  ]

return(
  <Box padding='1rem'>
    <Box borderRadius='1rem' display='flex' flexDirection='column' maxWidth='600px' margin='auto' border='1px solid black'>
      <UserDetails />

      {userOptions.map(option => {
        return <UserOption key={option.id} link={option.link} linkText={option.linkText}/>
      })}
    </Box>

  </Box>
);
}