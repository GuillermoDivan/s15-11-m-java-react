
interface IfetchData {
    path: string,
    method: string,
    body: any
}
export const fetchData = async (path: string, method: "GET" | "PUT" | "POST" | "DELETE", body: object): Promise<any> => {
    //export const fetchData = async ({ path, method, body }: IfetchData): Promise<any> => {
    try {
        return await (await fetch(`http://localhost:8080/${path}`, {
            method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: body ? JSON.stringify(body) : null
        })).json()
    } catch (error) {
        console.log(error);
        return { message: "ERROR DURANTE EL FETCH", error }

    }
}
