
export const passwordValidation = Object.freeze({
   required: {
      value: true,
      message: "Este campo es requerido."
   },
   minLength: {
      value: 7,
      message: "Debe contener al menos 7 caracteres."
   },
   maxLength: {
      value: 30,
      message: "Debe contener como máximo 30 caracteres."
   },
})

export const emailValidation = Object.freeze({
   required: {
      value: true,
      message: "Este campo es requerido."
   },
   minLength: {
      value: 6,
      message: "Debe contener al menos 6 caracteres."
   },
   pattern: {
      value: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/,
      message: "Incluye un signo '@' y '.' en la dirección de correo electrónico. Ej: 'correo@dominio.com'"
   }
})

export const namesValidation = Object.freeze({
   required: {
      value: true,
      message: "Este campo es requerido."
   },
   maxLength: {
      value: 20,
      message: "Debe contener como máximo 20 caracteres."
   }, minLength: {
      value: 3,
      message: "Debe contener al menos 3 caracteres."
   },
   pattern: {
      value: /^[a-zA-Z\s]*$/,
      message: "Solo se permiten letras y espacios."
   }
})