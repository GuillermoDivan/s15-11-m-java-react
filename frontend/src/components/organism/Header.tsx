import { AppBar, Toolbar, Typography, Box } from "@mui/material"
import Link from "next/link";
import dynamic from "next/dynamic";
import AccountMenu from "./AccountMenu";
import Image from "next/image";

const SliderNavbar = dynamic(() => import("../molecules/SliderNavbar"), { ssr: false })
const TabNavbar = dynamic(() => import("../molecules/TabNavbar"), { ssr: false })


const Header = () => {

    return (
        <AppBar position="static" sx={{ bgcolor: "#000" }}>
            <Toolbar sx={{ margin: 0, minHeight: { lg: "55px", md: "55px" } }}>

                <SliderNavbar />

                <Box flexGrow={1} display={"flex"} alignItems={"center"} gap={1} >
                    <Image
                        priority
                        alt="pop-corn-icon"
                        src={"/popcorn-icon.png"}
                        width={48}
                        height={48}
                    />
                    <Typography variant="h5" component={Link} href="/peliculas/en-pantalla"  >
                        PopcornPass
                    </Typography>
                </Box>

                <TabNavbar />

                <AccountMenu />

            </Toolbar>
        </AppBar>
    )
}

export default Header