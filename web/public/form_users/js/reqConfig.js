const port = '8080';

const reqConfig = {
	create: {
		method: 'POST',
		validation: body => {
			const { name, email, password, adress } = body;
			if (!name || !email || !password || !adress) {
				alert("The fields 'Name', 'E-mail', 'Password' and 'Adress' are required.");
				return;
			}
			return {
				url: `http://localhost:${port}/users/add`,
				body: JSON.stringify(body),
			};
		},
	},
	read: {
		method: 'GET',
		validation: ({ id = '' }) => {
			return {
				url: `http://localhost:${port}/users/${id}`,
				body: null,
			};
		},
	},
	update: {
		method: 'PUT',
		validation: body => {
			const { name, email, password, adress } = body;
			if ((!name, !email || !password || !adress)) {
				alert('All fields are required.');
				return;
			}
			return {
				url: `http://localhost:${port}/users/update/${id}`,
				body: JSON.stringify(body),
			};
		},
	},
	delete: {
		method: 'DELETE',
		validation: ({ id = '' }) => {
			if (!id) {
				alert("The fields 'Id' is required.");
				return;
			}
			return {
				url: `http://localhost:${port}/users/delete/${id}`,
				body: null,
			};
		},
	},
};

export default reqConfig;
