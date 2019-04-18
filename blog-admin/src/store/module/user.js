import
{
  login,
  getUserInfo,
  logout,
} from '@/api/login';
import
{
  getToken,
  setToken,
} from '@/utils/utils';

export default {
  state: {
    userName: '',
    userId: '',
    avatorImgpath: '',
    token: getToken(),
    hasGetInfo: false,
    access: [],
    roleList: [],
  },
  mutations: {
    SET_USERNAME(state, userName) {
      state.userName = userName;
    },
    SET_USERID(state, userId) {
      state.userId = userId;
    },
    SET_AVATOR(state, avatorImgpath) {
      state.avatorImgpath = avatorImgpath;
    },
    SET_TOKEN(state, token) {
      state.token = token;
      setToken(token);
    },
    SET_ACCESS(state, access) {
      state.access = access;
    },
    SET_HASGETINFO(state, status) {
      state.hasGetInfo = status;
    },
    SET_ROLELIST(state, roleList) {
      state.roleList = roleList;
    },
  },
  getters: {

  },
  actions: {
    /**
     * @description 登陆
     */
    handleLogin({ commit }, { username, password }) {
      username = username.trim();
      return new Promise((resolve, reject) => {
        login({ username, password }).then((res) => {
          if (res.code === 200) {
            const { data } = res;
            commit('SET_TOKEN', data);
            resolve();
          } else {
            reject(res);
          }
        }).catch(error => reject(error));
      });
    },
    /**
     * @description 退出登陆
     */
    handleLogout({ commit }) {
      return new Promise((resovle, reject) => {
        logout().then(() => {
          commit('SET_TOKEN', '');
          commit('SET_ACCESS', []);
          resovle();
        }).catch(error => reject(error));
      });
    },
    /**
     * @description 获取用户信息
     */
    getUserInfo({ commit }) {
      return new Promise((resolve, reject) => {
        getUserInfo().then((res) => {
          if (res.code === 200) {
            const { data } = res;
            commit('SET_USERNAME', data.username);
            commit('SET_USERID', data.userId);
            commit('SET_ROLELIST', data.roles);
            commit('SET_HASGETINFO', true);
            const access = data.roles.map(item => item.roleName);
            commit('SET_ACCESS', access);
            data.access = access;
            console.log(data);
            resolve(data);
          } else {
            reject(res);
          }
        }).catch(error => reject(error));
      });
    },
  },
};
