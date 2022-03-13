import setFetchParams from './fetchParams.js';
import reqConfig from './reqConfig.js';

const form = document.getElementById('form');
const inpId = document.getElementById('inpId');
const inpName = document.getElementById('inpName');
const inpPrice = document.getElementById('inpPrice');
const inpImgUrl = document.getElementById('inpImgUrl');

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
			id: inpId.value,
			name: inpName.value,
			price: inpPrice.value,
			img_url: inpImgUrl.value,
		};
		reqData(selectedMethod, data);
	}
});
