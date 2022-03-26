import setFetchParams from './fetchParams.js';
import reqConfig from './reqConfig.js';

const form = document.getElementById('form');
const inpName = document.getElementById('inpName');
const inpEmail = document.getElementById('inpEmail');
const inpPassword = document.getElementById('inpPassword');
const inpAdress = document.getElementById('inpAdress');

const reqData = async ({ method, validation }, data) => {
	const { url, body } = validation(data);
	const { urlApi, defaultOptions } = setFetchParams(method, body, url);
	const req = await fetch(urlApi, defaultOptions);
	const res = await req.json();
	console.log(res);
};

form.addEventListener('click', e => {
	if (e.target.id.includes('btn')) {
		const sliceMethod = e.target.id.slice(3).toLowerCase();
		const selectedMethod = reqConfig[sliceMethod];
		const data = {
			name: inpName.value.trim(),
			email: inpEmail.value.trim(),
			password: inpPassword.value.trim(),
			adress: inpAdress.value.trim(),
		};
		reqData(selectedMethod, data);
	}
});
