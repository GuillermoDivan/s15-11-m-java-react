"use client"
import { Box, Drawer, ListItemText, List, ListItem, ListItemButton, useTheme, Button, useMediaQuery, Container } from "@mui/material"
import { useMenuState } from '@/store/ui-store';
import { shallow } from "zustand/shallow";
import Link from "next/link";
import BoxButtonSvg from "@/components/atoms/BoxButtonSvg";
import { usePathname } from "next/navigation";
import routes from "@/data/routesData";
import { useAuthStore } from "@/store/auth-store";


const Navbar = () => {
    const { logOut, isLogged } = useAuthStore(state => ({
        logOut: state.logOut,
        isLogged: state.isLogged
    }), shallow)

    const theme = useTheme()
    const isMatch = useMediaQuery(theme.breakpoints.down("md"))

    const pathName = usePathname()
    const isActive = routes.findIndex(route => pathName.endsWith(route.path));

    const { isSideMenuOpen, openSideMenu, closeSideMenu, layoutBackgroundColor } = useMenuState(state => ({
        isSideMenuOpen: state.isSideMenuOpen,
        openSideMenu: state.openSideMenu,
        closeSideMenu: state.closeSideMenu,
        layoutBackgroundColor: state.layoutBackgroundColor
    }), shallow)

    const handleMenuState = () => isSideMenuOpen ? closeSideMenu() : openSideMenu()

    if (!isMatch) { return }
    return (<>
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


                <Container sx={{ display: "flex", flexWrap: "wrap", flexDirection: "column", justifyContent: "center" }}>

                    <Button variant="contained" color="warning" LinkComponent={Link}
                        href="/usuario/iniciar-sesion" children="mi perfil" onClick={closeSideMenu}
                        sx={{ width: "70%", minHeight: "2.5rem", margin: "auto" }}
                    />


                    {isLogged &&
                        <Button variant="contained" type="button"
                            sx={{ width: "70%", minHeight: "2.5rem", margin: "1.5rem auto" }}
                            onClick={() => { logOut(); closeSideMenu() }}
                            color="error" children="Cerrar sesión"
                        />}

                    <ListItemText sx={{ color: "#fff9", p: 2 }}>
                        Que esperas para obtener tu entrada!
                    </ListItemText>
                </Container>

            </Box>
        </Drawer>

    </>)
}

export default Navbar