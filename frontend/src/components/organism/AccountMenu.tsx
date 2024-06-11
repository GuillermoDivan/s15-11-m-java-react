"use client"
import { useState, MouseEvent } from "react";
import { Avatar, Menu, MenuItem, Divider, IconButton, Tooltip, Typography } from "@mui/material";
import { useAuthStore } from "@/store/auth-store";
import { shallow } from "zustand/shallow";
import { SxProps } from "@mui/material";
import AuthMenuItems from "../molecules/AuthMenuItems";
import MenuItems from "../atoms/MenuItems";

const styled: SxProps = {
    bgcolor: "var(--lightBlack)",
    color: "var(--light-gray-color)",
    overflow: "visible",
    filter: "drop-shadow(0px 2px 8px var(--black))",
    mt: 1.5,
    "& .MuiButtonBase-root:hover": { bgcolor: "var(--black)", color: "var(--white)" },
    "& .MuiDivider-root": { borderColor: "#f2f2f230" },
    "& .MuiAvatar-root": {
        width: 32,
        height: 32,
        ml: -0.5,
        mr: 1,
    },
    "&::before": {
        content: "''",
        display: "block",
        position: "absolute",
        top: 0,
        right: 14,
        width: 16,
        height: 16,
        bgcolor: "var(--lightBlack)",
        transform: "translateY(-50%) rotate(45deg)",
        zIndex: 0,
    },
}


const AccountMenu = () => {
    const [anchorEl, setAnchorEl] = useState<null | HTMLElement>(null);
    const open = Boolean(anchorEl);
    const handleClick = (event: MouseEvent<HTMLElement>) => setAnchorEl(event.currentTarget);
    const handleClose = () => setAnchorEl(null);


    const { firstName, lastName, logOut, isLogged } = useAuthStore(state => ({ logOut: state.logOut, firstName: state.firstName, lastName: state.lastName, isLogged: state.isLogged }), shallow)

    return (
        <>
            <Tooltip title="Mi cuenta">
                <IconButton
                    onClick={handleClick}
                    size="small"
                    sx={{ ml: 2 }}
                    aria-controls={open ? "mi-cuenta" : undefined}
                    aria-haspopup="true"
                    aria-expanded={open ? "true" : undefined}
                >
                    <Avatar sx={{ bgcolor: "var(--black)", color: "var(--gray-color)", width: 32, height: 32 }} />
                </IconButton>
            </Tooltip>


            <Menu
                anchorEl={anchorEl}
                id="account-menu"
                open={open}
                onClose={handleClose}
                onClick={handleClose}
                slotProps={{
                    paper: {
                        elevation: 0,
                        sx: styled
                    }
                }}
                transformOrigin={{ horizontal: "right", vertical: "top" }}
                anchorOrigin={{ horizontal: "right", vertical: "bottom" }}
            >

                {
                    isLogged
                        ?
                        <MenuItem onClick={handleClose} sx={{
                            color: "var(--yellow)", flexDirection: "column", justifyContent: "center", "&:hover": { color: "var(--yellow)!important" }
                        }}>
                            <Typography variant="body1">
                                ¡Hola {firstName} {lastName}!
                            </Typography>
                            <Typography variant="body2">
                                5.500 MoviePoints
                            </Typography>
                        </MenuItem>
                        :
                        <AuthMenuItems handleClick={handleClose} />
                }


                {
                    isLogged &&
                    [<Divider key={0} />
                        , <MenuItems key={1}
                            handleClose={handleClose}
                            logOut={logOut}
                            firstName={firstName || "P"}
                    />]
                }
            </Menu>
        </>
    );
}

export default AccountMenu