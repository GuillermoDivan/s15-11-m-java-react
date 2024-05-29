import { FC, ReactNode } from 'react'
import InputMui from "../atoms/InputMui"
import { emailValidation, passwordValidation } from "@/data/commonFormValidation"
import { FieldErrors, FieldValues, UseFormRegister } from "react-hook-form";
import { Box } from '@mui/material';

export interface IFieldsLoginProps {
    register: UseFormRegister<FieldValues>;
    errors: FieldErrors<FieldValues>;
    children?: ReactNode;
}



const FieldsLogin: FC<IFieldsLoginProps> = ({ register, errors, children }) => <>
    <InputMui inputRegister={register("email", emailValidation)}
        inputName="email" inputType="text" inputLabel="Ingresa tu correo electronico"
        inputHelperText={String(errors.email?.message)}
        inputError={errors.email ? true : false}
    />

    <Box display="flex" gap="1rem" sx={{ flexDirection: { xs: "column", md: "row" } }}>
        <InputMui inputSx={!children ? {width:"100%"} : {}} inputRegister={register("password", passwordValidation)}
            inputName="password" inputLabel="Ingresa tu contraseña"
            inputHelperText={String(errors.password?.message)}
            inputError={errors.password ? true : false}
        />
        {children}
    </Box>
</>


export default FieldsLogin