import type { Metadata } from "next";
import "./globals.css";
import { Inter } from "next/font/google";
import  Navbar from "@/components/organism/Header";
import Footer from "@/components/organism/Footer";

const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "Next App",
  description: "Proyecto en proceso...",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="es">
      <body className={inter.className}>
        <Navbar />
        <main>
          {children}
        </main>
        <Footer />
      </body>
    </html>
  );
}
