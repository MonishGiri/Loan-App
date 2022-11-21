import React, { useState } from 'react';
import './style.css'
function RegistrationForm() {
	return (
		<div className="form">
			<div className="form-body">
				<div className="email">
					<label className="form__label" for="email">Email </label>
					<input type="email" id="email" className="form__input" placeholder="Email" />
				</div>
				<div className="password">
					<label className="form__label" for="password">Password </label>
					<input className="form__input" type="password" id="password" placeholder="Password" />
				</div>
				<div className="username">
					<label className="form__label" for="firstName">First Name </label>
					<input className="form__input" type="text" id="firstName" placeholder="First Name" />
				</div>
				<div className="lastname">
					<label className="form__label" for="lastName">Last Name </label>
					<input type="text" name="" id="lastName" className="form__input" placeholder="LastName" />
				</div>

				<div className="Mobile Number">
					<label className="form__label" for="mobile">Mobile Number </label>
					<input className="form__input" type="text" id="address" />
				</div>
			</div>
			<div className="Address">
					<label className="form__label" for="address">Address</label>
					<input className="form__input" type="text" id="confirmPassword"/>
				</div>
		</div>
	)
}
export default RegistrationForm;