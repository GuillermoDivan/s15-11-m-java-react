interface IRoute {
    name: string;
    path: string;
}

const routes: ReadonlyArray<IRoute> = Object.freeze([
    {
        name: "peliculas",
        path: "/peliculas/en-pantalla"
    },
    {
        name: "puntos",
        path: "/#"
    },
    {
        name: "promociones",
        path: "/#"
    },
    {
        name: "cines",
        path: "/#"
    },
    {
        name: "nosotros",
        path: "/nosotros"
    },
]);

export default routes;
