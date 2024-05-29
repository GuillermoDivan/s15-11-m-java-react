import Loader from "@/components/atoms/Loader";
import { Container, Typography } from "@mui/material";
import type { Metadata } from "next";
import dynamic from "next/dynamic";

const FormLogin = dynamic(() => import("@/components/organism/FormLogin"), { ssr: false, loading: () => <Loader /> })
const FormRegister = dynamic(() => import("@/components/organism/FormRegister"), { ssr: false, loading: () => <Loader /> })

export const metadata: Metadata = {
    title: "Inicia sesión o Regístrate",
    description: "Inicia sesión en NextApp para conseguir tus entradas!"
};

const Page = ({ params }: { params: { auth: "iniciar-sesion" | "registro" } }) => {
    const { auth } = params

    if (auth != "iniciar-sesion" && auth != "registro") return <h1 style={{ margin: "auto", textAlign: "center" }}>404 - Not Found</h1>

    return (
        <Container sx={{ backgroundColor: "var(--lightBlack)", margin: "2.3rem auto", borderRadius: "20px", padding: "2.3rem 1rem", width: { xs: "80%", md: "450px" } }}>
            <Typography variant="h4" textAlign="center" sx={{ margin: ".5rem auto 2rem" }}>
                {auth == "registro" ? "Registrate" : "Inicia Sesión"} en NextApp
            </Typography>
            {
                auth == "registro"
                    ? <FormRegister />
                    : <FormLogin />
            }
        </Container>
    )


}

export default Page