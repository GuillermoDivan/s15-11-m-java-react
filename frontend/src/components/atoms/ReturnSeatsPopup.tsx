import React, { useState } from 'react';
import { fetchData } from '../../utils/fetchData';
import { useAuthStore } from "@/store/auth-store"; // Ajusta la ruta según tu estructura de proyecto

interface Ticket {
  id: string;
  userId: string;
  cinemaName: string;
  screenName: string;
  movieName: string;
  seatsIds: string[];
  functionDate: string;
  value: number;
  active: boolean;
}

interface ReturnSeatsPopupProps {
  ticket: Ticket;
  onClose: () => void;
}

const popupStyle: React.CSSProperties = {
  position: 'fixed',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  background: '#333', // Fondo oscuro
  color: '#fff', // Texto claro
  padding: '20px',
  boxShadow: '0 0 10px rgba(0, 0, 0, 0.5)', // Sombra más pronunciada
  zIndex: 1000,
  borderRadius: '10px', // Bordes redondeados
  width: '400px', // Ancho fijo
  textAlign: 'center', // Centrar el texto
};

const ulStyle: React.CSSProperties = {
  listStyle: 'none',
  padding: 0,
  margin: 0, // Elimina el margen
};

const liStyle: React.CSSProperties = {
  marginTop: '20px',
  marginBottom: '10px',
};

const buttonStyle: React.CSSProperties = {
  marginTop: '15px', // Espacio superior
  marginRight: '10px', // Espacio derecho
  padding: '10px 20px', // Añadir padding para tamaño del botón
  backgroundColor: '#555', // Fondo del botón
  color: '#fff', // Color del texto del botón
  border: 'none', // Sin borde
  borderRadius: '5px', // Bordes redondeados
  cursor: 'pointer', // Cambia el cursor al pasar por el botón
};

const ReturnSeatsPopup: React.FC<ReturnSeatsPopupProps> = ({ ticket, onClose }) => {
  const [selectedSeats, setSelectedSeats] = useState<string[]>([]);
  const [showNotification, setShowNotification] = useState(false);

  const handleSeatSelection = (seat: string) => {
    setSelectedSeats((prev) =>
      prev.includes(seat) ? prev.filter(s => s !== seat) : [...prev, seat]
    );
  };
  const handleRedirect = () => {
    window.location.href = '/peliculas/en-pantalla';
    setShowNotification(true); // Mostrar notificación después de redirigir
  };

  return (
    <div style={popupStyle}>
      <p>Devolver Asientos para la pelicula:</p>
      <h3>{ticket.movieName}</h3>
      <ul style={ulStyle}>
        {ticket.seatsIds.map(seat => (
          <li key={seat} style={liStyle}>
            <label>
              <input 
                type="checkbox" 
                value={seat}
                onChange={() => handleSeatSelection(seat)}
              />
              {seat}
            </label>
          </li>
        ))}
      </ul>
      <div>
      <button style={buttonStyle} onClick={handleRedirect}>Devolver</button>
      <button style={{ ...buttonStyle, marginRight: 0 }} onClick={onClose}>Cerrar</button>
      </div>
      {showNotification && (
        <div style={{ background: 'green', color: 'white', padding: '10px', marginTop: '20px' }}>
          ¡Notificación de devolución de asientos!
        </div>
      )}
    </div>
  );
};

export default ReturnSeatsPopup;
