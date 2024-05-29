import { AppBar, Toolbar, Typography, Box } from "@mui/material"
import Link from "next/link";
import dynamic from "next/dynamic";

const SliderNavbar = dynamic(() => import("../molecules/SliderNavbar"), { ssr: false })
const TabNavbar = dynamic(() => import("../molecules/TabNavbar"), { ssr: false })


const Header = () => {

    return (
        <AppBar position="static" sx={{bgcolor:"#000"}}>
            <Toolbar>

                <SliderNavbar />

                <Box flexGrow={1}>
                    <Typography variant="h5" component={Link} href="/"  >
                        NextApp
                    </Typography>
                </Box>

                <TabNavbar />

            </Toolbar>
        </AppBar>
    )
}

export default Header