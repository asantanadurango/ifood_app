const setFetchParams = (id, method, body) => {
	const urlApi = `http://localhost:8080/${id}`;
	const defaultOptions = {
		method,
		headers: {
			'Content-Type': 'application/json',
		},
		body,
	};
	return {
		urlApi,
		defaultOptions,
	};
};

export default setFetchParams;
