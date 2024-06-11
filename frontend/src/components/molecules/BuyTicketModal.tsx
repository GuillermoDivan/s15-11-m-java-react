import { FC, useState } from 'react';
import Backdrop from '@mui/material/Backdrop';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import Fade from '@mui/material/Fade';
import Typography from '@mui/material/Typography';
import { Button, SxProps } from '@mui/material';
import Image from 'next/image';
import { useRouter } from 'next/navigation';
import Loading from '@/app/loading';

const style : SxProps = {
    position: 'absolute' as 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: { xs: "95%", sm: 400 },
    color: "#000",
    borderRadius: 3,
    boxShadow: 24,
    px: 2,
    py: 3,
    bgcolor:"var(--lightBlack)" 
};

export interface InfoItem {
    value: string,
    name: string
}

interface Props {
    open: boolean
    setOpen: (state: boolean) => void
    info: InfoItem[]
}

const BuyTicketModal: FC<Props> = ({ open, setOpen, info }) => {
    const [isChecked, setIsChecked] = useState(false);
    const [isLoading, setIsLoading] = useState(false);
    const router = useRouter();

    const handleClose = () => {
        setOpen(false);
        setIsChecked(false);
        if(!isChecked){return}
        router.push("/peliculas/en-pantalla");
    };

    const handleSubmitCheck = () => {
        setIsLoading(true);
        setTimeout(() => {
            setIsLoading(false);
            setIsChecked(true);
        }, 2000);
    };

    return (
        <Modal
            aria-labelledby="transition-modal-title"
            aria-describedby="transition-modal-description"
            open={open}
            onClose={handleClose}
            closeAfterTransition
            slots={{ backdrop: Backdrop }}
            slotProps={{
                backdrop: {
                    timeout: 500,
                },
            }}
        >
            <Fade in={open}>
                <Box
                    sx={style}
                >
                    {isLoading ? (
                        <Loading />
                    ) : isChecked ? (
                        <Box>
                            <Box bgcolor="var(--lightBlack)" p={3} width={"fit-content"} borderRadius={100} border={"solid 5px var(--yellow)"} mx={"auto"}>
                                <Image
                                    alt={"check-icon"}
                                    width={128}
                                    height={128}
                                    src={"/images/check-icon.png"}
                                />
                            </Box>
                            <Typography color={"var(--yellow)"} variant={"h5"} textAlign={"center"} my={3}>
                                Gracias por tu compra!
                            </Typography>
                            <Typography variant={"body1"} textAlign={"center"} mb={3} color={"var(--light-gray-color)"}>
                                Te enviamos un correo con los detalles.
                            </Typography>
                            <Button variant="contained"
                                onClick={handleClose} sx={{ fontWeight: 600, minHeight: "2.6rem", width: "100%" }} color="warning">
                                Cerrar
                            </Button>
                        </Box>
                    ) : (
                        <Box>
                            {info.map(item => (
                                <Box key={item.name} display="flex" width={"100%"} overflow={"hidden"} alignItems={"center"} justifyContent={"space-between"}>
                                    <Typography textTransform={"capitalize"} color={"var(--gray-color)"} maxWidth={"30%"} textAlign={"left"}>
                                        {item.name}:
                                    </Typography>
                                    <Typography textTransform={"capitalize"} noWrap color={"var(--gray-color)"} maxWidth={"70%"} textAlign={"right"} fontWeight={600}>
                                        {item.value}
                                    </Typography>
                                </Box>
                            ))}

                            <hr style={{margin:"1rem 0"}} />

                            <Box width={"95%"} margin="1rem auto 0">
                                <Typography variant={"h5"} color={"var(--light-white-color)"} textAlign={"center"} sx={{ mb: 2 }}>
                                    Elige tu medio de Pago
                                </Typography>

                                <Box display="flex" justifyContent={"space-between"} mb={1.5}>
                                    <Button variant="contained"
                                        onClick={handleSubmitCheck}
                                        sx={{ fontWeight: 600, minHeight: "2.6rem", width: "48%" }} color="info">
                                        mercado pago
                                    </Button>
                                    <Button variant="contained"
                                        onClick={handleSubmitCheck}
                                        sx={{ fontWeight: 600, minHeight: "2.6rem", width: "48%" }} color="warning">
                                        movie points
                                    </Button>
                                </Box>
                                <Button variant="contained" sx={{ marginTop: 2 }} fullWidth color="error" onClick={handleClose}>
                                    cancelar
                                </Button>
                            </Box>
                        </Box>
                    )}
                </Box>
            </Fade>
        </Modal>
    );
};

export default BuyTicketModal;
