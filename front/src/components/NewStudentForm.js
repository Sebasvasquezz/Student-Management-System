import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const NewStudentForm = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    program: '',
    mail: '',
    birthdate: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    axios.post('http://localhost:8080/newStudents', formData)
      .then(response => {
        alert('Student created successfully!');
      })
      .catch(error => {
        console.error('There was an error creating the student!', error);
      });
  };

  return (
    <div>
      <h2>Add New Student</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>First Name</label>
          <input type="text" name="firstName" value={formData.firstName} onChange={handleChange} />
        </div>
        <div>
          <label>Last Name</label>
          <input type="text" name="lastName" value={formData.lastName} onChange={handleChange} />
        </div>
        <div>
          <label>Program</label>
          <input type="text" name="program" value={formData.program} onChange={handleChange} />
        </div>
        <div>
          <label>Email</label>
          <input type="email" name="mail" value={formData.mail} onChange={handleChange} />
        </div>
        <div>
          <label>Birthdate</label>
          <input type="date" name="birthdate" value={formData.birthdate} onChange={handleChange} />
        </div>
        <button type="submit">Create Student</button>
      </form>
      <Link to="/students">View Student List</Link>
    </div>
  );
};

export default NewStudentForm;
