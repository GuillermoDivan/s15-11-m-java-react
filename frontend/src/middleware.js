import { NextResponse } from 'next/server'

export function middleware(request) {
  return NextResponse.redirect(new URL('/peliculas/en-pantalla', request.url))
}

export const config = {
  matcher: [
    "/",
  ],
}
