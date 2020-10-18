import React, {useState} from "react";
import "./App.css";
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import Form from 'react-bootstrap/Form'


function App() {

  const [registerData, setRegisterData] = useState([]);
  const [loginData, setloginData] = useState([]);
  const [todoData, setTodoData] = useState([]);


  function requestDataAll() {
    setTodoData([]);
    setRegisterData([]);
    setloginData([]);
    axios.get("https://my.api.mockaroo.com/habitica_register.json?key=1dd1d190")
    .then( res => {
      setRegisterData(res.data);
    });
    axios.get("https://my.api.mockaroo.com/habitica_login.json?key=1dd1d190")
    .then( res => {
      setloginData(res.data);
    });
    axios.get("https://my.api.mockaroo.com/habitica_todo.json?key=1dd1d190")
    .then( res => {
      setTodoData(res.data);
    });
  }

  function requestDataRegistro() {
    axios.get("https://my.api.mockaroo.com/habitica_register.json?key=1dd1d190")
    .then( res => {
      setTodoData([]);
      setloginData([]);
      setRegisterData(res.data);
    });
  }

  function requestDataLogin() {
    axios.get("https://my.api.mockaroo.com/habitica_login.json?key=1dd1d190")
    .then( res => {
      setTodoData([]);
      setRegisterData([]);
      setloginData(res.data);
    });
  }

  function requestDataTodo() {
    axios.get("https://my.api.mockaroo.com/habitica_todo.json?key=1dd1d190")
    .then( res => {
      setRegisterData([]);
      setloginData([]);
      setTodoData(res.data);
      console.log(res.data)
    });
  }


  return (
    <div className="wrapper">
      Generar:
      <Button variant="dark" style={{marginTop:"10px", marginLeft:"10px"}} onClick={requestDataAll}>Todos los campos</Button>
      <Button variant="dark" style={{marginTop:"10px", marginLeft:"10px"}} onClick={requestDataRegistro}>Registro</Button>
      <Button variant="dark" style={{marginTop:"10px", marginLeft:"10px"}} onClick={requestDataLogin}>Login</Button>
      <Button variant="dark" style={{marginTop:"10px", marginLeft:"10px"}} onClick={requestDataTodo}>To do's</Button>
      <div className="contentWrapper">
        {todoData.map(data => (
          <div>
          <Form>
            <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Title</Form.Label>
              <Form.Control type="Title" placeholder={data.title} readOnly as="textarea"/>
            </Form.Group>

            <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Notes</Form.Label>
              <Form.Control type="notes" placeholder={data.notes} readOnly as="textarea"/>
            </Form.Group>

            <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Date </Form.Label>
          <br/>
              {data.date}
            </Form.Group>
            

            <Form.Group controlId="formBasicCheckbox">
              <Form.Check type="checkbox" label="Has tags" defaultChecked={data.tags}/>
            </Form.Group>
            </Form>
            <hr class="dashed"/>
          </div>
        ))
        }
      </div>
          <div className="contentWrapper">
        {registerData.map(data => (
          <div>
          <Form>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control type="email" placeholder={data.email} readOnly/>
              <Form.Text className="text-muted">
                We'll never share your email with anyone else.
              </Form.Text>
            </Form.Group>

            <Form.Group controlId="formBasicEmail">
              <Form.Label>Username</Form.Label>
              <Form.Control type="username" placeholder={data.user_name} readOnly/>
            </Form.Group>

            <Form.Group controlId="formBasicEmail">
              <Form.Label>Password</Form.Label>
              <Form.Control type="email" placeholder={data.password} readOnly/>
            </Form.Group>
          </Form>
            <hr class="dashed"/>
          </div>
        ))
        }
      </div>
      <div className="contentWrapper">
        {loginData.map(data => (
          <div>
          <Form>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control type="email" placeholder={data.email} />
              <Form.Text className="text-muted">
                We'll never share your email with anyone else.
              </Form.Text>
            </Form.Group>

            <Form.Group controlId="formBasicEmail">
              <Form.Label>Password</Form.Label>
              <Form.Control type="email" placeholder={data.password} />
            </Form.Group>
          </Form>
            <hr class="dashed"/>
          </div>
        ))
        }
      </div>
    </div>
  );
}

export default App;
