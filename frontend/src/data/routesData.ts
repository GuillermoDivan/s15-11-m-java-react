interface IRoute {
    name: string;
    path: string;
}

const routes: ReadonlyArray<IRoute> = Object.freeze([
    {
        name: "inicio",
        path: "/"
    },
    {
        name: "cartelera",
        path: "/#"
    },
    {
        name: "estrenos",
        path: "/#"
    }
]);

export default routes;
