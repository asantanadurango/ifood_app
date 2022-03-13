const setFetchParams = (method, body, url) => {
	const urlApi = url;
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
