"use client"
import { useForm } from "react-hook-form"
import { Box, Button, Divider, Typography } from "@mui/material"
import Link from "next/link"
import FieldsLogin from "../molecules/FieldsLogin"
import InputMui from "../atoms/InputMui"
import { namesValidation, passwordValidation } from "@/data/commonFormValidation"
import { fetchData } from "../../utils/fetchData"
import { useState } from "react"

const FormRegister = () => {
    const [message, setMessage] = useState({ value: false, message: "" })

    const { register, handleSubmit, reset, watch, formState: { errors } } = useForm()
    const onSubmit = handleSubmit(async (data): Promise<void> => {
        const res = await fetchData("user/register", "POST", data)

        if (!res.id) return setMessage({ value: true, message: res.errorMessage ?? "Ocurrio un error, intentelo más tarde." })

        setMessage({ value: true, message: `${res.firstName} ${res.lastName}, te has registrado correctamente!` })
        reset()
        setTimeout(() => setMessage({ value: false, message: "" }), 7500);
    })

    return (
        <Box
            component="form"
            onSubmit={onSubmit}
            sx={{ display: "flex", flexDirection: "column", gap: "1rem"}}
        >

            <Box display="flex" gap="1rem">
                <InputMui inputName="firstName" inputType="text" inputLabel="Nombre"
                    inputRegister={register("firstName", namesValidation)}
                    inputHelperText={String(errors.firstName?.message)}
                    inputError={errors.firstName ? true : false}
                />

                <InputMui inputName="lastName" inputType="text" inputLabel="Apellido"
                    inputRegister={register("lastName", namesValidation)}
                    inputHelperText={String(errors.lastName?.message)}
                    inputError={errors.lastName ? true : false}
                />
            </Box>

            <FieldsLogin register={register} errors={errors}>

                <InputMui inputName="confirmPassword" inputType="password"
                    inputLabel={"Confirma tu contraseña"}
                    inputHelperText={String(errors.confirmPassword?.message)}
                    inputError={errors.confirmPassword ? true : false}
                    inputRegister={register("confirmPassword", {
                        ...passwordValidation,
                        validate: value => value == watch("password") ? true : "No coincide con su contraseña."
                    })}
                />
            </FieldsLogin>

            <Divider sx={{ bgcolor: "var(--gray-color)", margin: "12px 0" }} />

            {message.value &&
                <Typography color="var(--yellow)" textAlign="center" variant="h5" children={message.message} />}

            <Button type="submit" variant="contained" color="warning" children="Registrarme" />

            <Button type="button" LinkComponent={Link} href={"/usuario/iniciar-sesion"} variant="contained"
                children="Iniciar Sesión" color="info" sx={{ bgcolor: "var(--black)" }} />

        </Box>
    )
}

export default FormRegister