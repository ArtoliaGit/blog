<template>
  <el-scrollbar wrap-class="scrollbar-wrapper">
    <el-menu
      :default-active="$route.path"
      :collapse="isCollapse"
      mode="vertical"
      :router="true"
      background-color="#304156"
      text-color="#bfcbd9"
      active-text-color="#409eff"
      :style="{width: (isCollapse ? 'auto' : '250px') + '!important'}"
    >
      <template v-for="item in menuList">
        <template v-if="!item.children || (item.children && item.children.length === 0)">
          <el-menu-item :index="item.name" :key="item.name" :route="{ path: item.name }">
            <i :class="item.meta.icon" />
            <span slot="title">{{ item.meta.title }}</span>
          </el-menu-item>
        </template>
        <template v-else>
          <sidebar-item :item="item" :key="item.name" />
        </template>
      </template>
    </el-menu>
  </el-scrollbar>
</template>

<script>
import SidebarItem from './sidebar-item';

export default {
  name: 'SideMenu',
  components: {
    SidebarItem,
  },
  props: {
    menuList: {
      type: Array,
      required: true,
    },
    isCollapse: {
      type: Boolean,
      default: false,
    },
  },
};
</script>
