import Loader from "@/components/atoms/Loader";
import TicketList from "@/components/molecules/TicketList";
import { Container, Typography } from "@mui/material";
import type { Metadata } from "next";
import dynamic from "next/dynamic";

const FormLogin = dynamic(() => import("@/components/organism/FormLogin"), { ssr: false, loading: () => <Loader /> })
const FormRegister = dynamic(() => import("@/components/organism/FormRegister"), { ssr: false, loading: () => <Loader /> })

export const metadata: Metadata = {
    title: "Tus tickets en PopcornPass",
    description: "Todo aca"
};

const Page = () => {
 
    return(
    <div>
        <TicketList></TicketList>
    </div>)

}

export default Page