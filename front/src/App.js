import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [students, setStudents] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [newStudent, setNewStudent] = useState({
    firstName: '',
    lastName: '',
    program: '',
    mail: '',
    birthdate: ''
  });

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {
      const response = await axios.get('http://localhost:8080/getAllStudents');
      setStudents(response.data);
    } catch (error) {
      console.error('Error fetching students:', error);
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewStudent({
      ...newStudent,
      [name]: value
    });
  };

  const handleFormSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/addNewStudents', newStudent);
      fetchStudents();
      setShowForm(false);
      setNewStudent({
        firstName: '',
        lastName: '',
        program: '',
        mail: '',
        birthdate: ''
      });
    } catch (error) {
      console.error('Error adding student:', error);
    }
  };

  return (
    <div className="App">
      <h1>Student List</h1>
      <table className="student-table">
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Program</th>
            <th>Birthdate</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.firstName}</td>
              <td>{student.lastName}</td>
              <td>{student.program}</td>
              <td>{student.birthdate}</td>
              <td>{student.mail}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <button onClick={() => setShowForm(!showForm)}>
        {showForm ? 'Cancel' : 'Add New Student'}
      </button>
      {showForm && (
        <form onSubmit={handleFormSubmit}>
          <input
            type="text"
            name="firstName"
            value={newStudent.firstName}
            onChange={handleInputChange}
            placeholder="First Name"
            required
          />
          <input
            type="text"
            name="lastName"
            value={newStudent.lastName}
            onChange={handleInputChange}
            placeholder="Last Name"
            required
          />
          <input
            type="text"
            name="program"
            value={newStudent.program}
            onChange={handleInputChange}
            placeholder="Program"
            required
          />
          <input
            type="email"
            name="mail"
            value={newStudent.mail}
            onChange={handleInputChange}
            placeholder="Email"
            required
          />
          <input
            type="date"
            name="birthdate"
            value={newStudent.birthdate}
            onChange={handleInputChange}
            placeholder="Birthdate"
            required
          />
          <button type="submit">Add Student</button>
        </form>
      )}
    </div>
  );
}

export default App;
