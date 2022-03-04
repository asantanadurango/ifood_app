const reqConfig = {
	create: {
		method: 'POST',
		validation: body => {
			const { name, salary } = body;
			if (!name || !salary) {
				alert(
					"The fields 'Name' and 'Salary' are required."
				);
				return;
			}
			return {
				id: '',
				body: JSON.stringify(body),
			};
		},
	},
	read: {
		method: 'GET',
		validation: ({ id }) => {
			return {
				id,
				body: null,
			};
		},
	},
	update: {
		method: 'PUT',
		validation: body => {
			const { id, name, salary } = body;
			if ((!id, !name || !salary)) {
				alert('All fields are required.');
				return;
			}
			return {
				id: '',
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
				id,
				body: null,
			};
		},
	},
};

export default reqConfig;
