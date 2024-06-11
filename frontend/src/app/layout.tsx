import type { Metadata } from "next";
import "./globals.css";
import { Inter } from "next/font/google";
import Header from "@/components/organism/Header";
import Footer from "@/components/organism/Footer";
import { Suspense } from "react";
const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  generator: "Next.js",
  referrer: "origin-when-cross-origin",
  title: "PopcornPass",
  description: "Plataforma para exhibir y gestionar películas, horarios y boletos de los cines adheridos en nuestro sitio. Buscamos facilitar la elección del cliente para seleccionar su película y su cine.",
  keywords: "popcorn pass, PopcornPass, cines, cine, cartelera, estrenos, estreno, horarios, horario, preventas, próximos estrenos, proximos estrenos, eventos, compra online, compra candy online, candy, concesión, cine fan, complejos, argentina, PREMIUM, COMFORT, 2D, 3D, 4D, XD, DBOX",
  authors: [{ name: "Maidana Franco" }, { name: "Nordinelli Franco" }],
  icons: ["/popcorn-icon.png", "/favicon.ico"],
  openGraph: {
    images: '/popcorn-icon.png',
    title: 'PopcornPass',
    description: 'Plataforma para exhibir y gestionar películas, horarios y boletos de los cines adheridos en nuestro sitio. Buscamos facilitar la elección del cliente para seleccionar su película y su cine.',
    url: 'https://popcorn-pass-maidana07-projects.vercel.app/peliculas/en-pantalla',
    siteName: 'PopcornPass',
    locale: 'es_AR',
    type: 'website',
  },

};

export const viewport = { themeColor: '#FCC434' }


export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="es">
      <body className={inter.className}>
        <Header />
        <main>
          <Suspense>
            {children}
          </Suspense>
        </main>
        <Footer />
      </body>
    </html>
  );
}
