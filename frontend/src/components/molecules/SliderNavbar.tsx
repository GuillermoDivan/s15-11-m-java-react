"use client"
import { Box, Drawer, ListItemText, List, ListItem, ListItemButton, useTheme, useMediaQuery, Container } from "@mui/material"
import { useMenuState } from '@/store/ui-store';
import { shallow } from "zustand/shallow";
import Link from "next/link";
import BoxButtonSvg from "@/components/atoms/BoxButtonSvg";
import routes from "@/data/routesData";
import isLinkActive from "@/utils/isLinkActive";
import { Fragment } from "react";
import { usePathname } from "next/navigation";



const Navbar = () => {
    const theme = useTheme()
    const isMatch = useMediaQuery(theme.breakpoints.down("md"))
    const pathName = usePathname()
    const isActive = isLinkActive(pathName)


    const { isSideMenuOpen, openSideMenu, closeSideMenu, layoutBackgroundColor } = useMenuState(state => ({
        isSideMenuOpen: state.isSideMenuOpen,
        openSideMenu: state.openSideMenu,
        closeSideMenu: state.closeSideMenu,
        layoutBackgroundColor: state.layoutBackgroundColor
    }), shallow)

    const handleMenuState = () => isSideMenuOpen ? closeSideMenu() : openSideMenu()

    if (!isMatch) { return }
    return (<Fragment>
        <BoxButtonSvg
            alt="open-menu"
            handleClick={handleMenuState}
            sxBox={{ marginRight: "15px", }}
            sxButton={{
                minWidth: "auto", p: 0,
            }}
            sizesInPx={{ height: 40, width: 40 }}
            path="/images/header/menu.svg"
        />

        <Drawer
            open={isSideMenuOpen}
            onClose={handleMenuState}
            sx={{
                '--Drawer-transitionDuration': isSideMenuOpen ? '0.4s' : '0.2s',
                '--Drawer-transitionFunction': isSideMenuOpen
                    ? 'cubic-bezier(0.79,0.14,0.15,0.86)'
                    : 'cubic-bezier(0.77,0,0.18,1)',
                '& .MuiDrawer-paper': {
                    bgcolor: layoutBackgroundColor,
                    width: { xs: "85%", sm: "65%", md: "40%" },
                },
            }}
        >

            <BoxButtonSvg
                sxBox={{ textAlign: "end", minHeight: "56px", alignItems: "center", p: "6px 8px" }}
                alt="close-menu"
                handleClick={handleMenuState}
                sizesInPx={{ height: 40, width: 40 }}
                path="/images/header/close.svg"
            />

            <Box sx={{ width: '100%', height: "100%", display: "flex", marginTop: "auto", flexDirection: "column", justifyContent: "space-between", textAlign: "center" }} role="navigation" component="nav">

                <List sx={{ color: "rgba(255, 255, 255, 0.5)" }}>
                    {routes.map(({ name, path }, i) => (
                        <ListItem key={i} disablePadding onClick={handleMenuState}>
                            <ListItemButton LinkComponent={Link} href={path} sx={{ p: 2 }}>
                                <ListItemText
                                    primary={name}
                                    primaryTypographyProps={{
                                        color: isActive == i ? "#fff" : "inherit",
                                        textTransform: "capitalize", fontSize: "1.33rem", textAlign: 'center'
                                    }}
                                />
                            </ListItemButton>
                        </ListItem>
                    ))}
                </List>

            </Box>
        </Drawer>

    </Fragment>)
}

export default Navbar