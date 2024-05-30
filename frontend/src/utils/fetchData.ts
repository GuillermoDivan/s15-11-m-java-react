

export const fetchData = async (path: string, method: "GET" | "PUT" | "POST" | "DELETE", body?: object, token?: string): Promise<any> => {
    try {
        const headers: HeadersInit = { "Content-Type": "application/json" };
        token && (headers["Authorization"] = `Bearer ${token}`)
        const options: RequestInit = { method, headers }
        body && method != "GET" && (options.body = JSON.stringify(body))

        const res = await fetch(`http://localhost:8080/${path}`, options)

        return await res.json()
    } catch (error) {
        console.log(error);
        return { message: "ERROR DURANTE EL FETCH", error }

    }
}
