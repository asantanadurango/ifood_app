const port = '8080';

const reqConfig = {
	create: {
		method: 'POST',
		validation: body => {
			const { name, price, img_url } = body;
			if (!name || !price || !img_url) {
				alert("The fields 'Name', 'Price' and 'Img' are required.");
				return;
			}
			return {
				url: `http://localhost:${port}/products/add`,
				body: JSON.stringify(body),
			};
		},
	},
	read: {
		method: 'GET',
		validation: ({ id }) => {
			return {
				url: `http://localhost:${port}/products/${id}`,
				body: null,
			};
		},
	},
	update: {
		method: 'PUT',
		validation: body => {
			const { id, name, price } = body;
			if ((!id, !name || !price)) {
				alert('All fields are required.');
				return;
			}
			return {
				url: `http://localhost:${port}/products/update/${id}`,
				body: JSON.stringify(body),
			};
		},
	},
	delete: {
		method: 'DELETE',
		validation: ({ id }) => {
			if (!id) {
				alert("The fields 'Id' is required.");
				return;
			}
			return {
				url: `http://localhost:${port}/products/delete/${id}`,
				body: null,
			};
		},
	},
};

export default reqConfig;
